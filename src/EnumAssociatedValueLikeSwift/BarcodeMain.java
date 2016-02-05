package EnumAssociatedValueLikeSwift;

import com.sun.tools.javac.comp.Check;
import com.sun.tools.javac.util.List;

import java.util.ArrayList;

/**
 * Created by wzhao on 2/5/16.
 */
public class BarcodeMain {
    public static void main(String[] args) throws Exception {
        List<Barcode> barcodes = new ArrayList<>();
        barcodes.add(Barcode.newUPCA(8, 85909, 51226, 3));
        barcodes.add(Barcode.newQRCode("foobar"));

        for (Barcode barcode: barcodes) {
            switch (barcode.getType()) {
                case UPCA: {
                    BarcodeUPCA b = (BarcodeUPCA) barcode;
                    System.out.printf("UPC-A: %d, %d, %d, %d%n",
                            b.getNumberSystem(),
                            b.getManufacturer(),
                            b.getProduct(),
                            b.getCheck()
                    );
                    break;
                }
                case QRCode: {
                    BarcodeQRCode b = (BarcodeQRCode) barcode;
                    System.out.printf("QR code: %s%n", b.getProductCode());
                    break;
                }
                default:
                    System.err.println("unhandled type: " + barcode.getType());
            }
        }
    }
}

// enum
enum BarCodeType {
    UPCA,
    QRCode,
    UNDEFINED;
}

// factory class
abstract class Barcode {
    abstract public BarCodeType getType();

    public static final Barcode newUPCA(int numberSystem, int manufacture, int product, int check ) {
        return new BarcodeUPCA(numberSystem, manufacture, product, check);
    }

    public static final Barcode newQRCode(String productCode) {
        return new BarcodeQRCode(productCode);
    }
}

// concrete implementation UPCA
class BarcodeUPCA extends Barcode {
    private final int numberSystem;
    private final int manufactures;
    private final int product;
    private final int check;

    public BarcodeUPCA(int numberSystem, int manufactures, int product, int check) {
        this.numberSystem = numberSystem;
        this.manufactures = manufactures;
        this.product = product;
        this.check = check;
    }

    public int getNumberSystem() {
        return numberSystem;
    }

    public int getManufactures() {
        return manufactures;
    }

    public int getProduct() {
        return product;
    }

    public int getCheck() {
        return check;
    }

    @Override
    public BarCodeType getType() {
        return BarCodeType.UPCA;
    }
}

// concrete implementation QRCode
class BarcodeQRCode extends Barcode {
    private final String productCode;

    public BarcodeQRCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    @Override
    public BarCodeType getType() {
        return BarCodeType.QRCode;
    }

}