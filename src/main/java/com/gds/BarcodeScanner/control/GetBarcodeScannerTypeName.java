package com.gds.BarcodeScanner.control;

import jpos.ScannerConst;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetBarcodeScannerTypeName {

    public String execute(int code) {
        String val = "Unknown";
        switch (code) {
            case ScannerConst.SCAN_SDT_UPCA:
                val = "UPC-A";
                break;
            case ScannerConst.SCAN_SDT_UPCE:
                val = " UPC-E";
                break;
            case ScannerConst.SCAN_SDT_JAN8:
                val = "JAN 8 / EAN 8";
                break;
            case ScannerConst.SCAN_SDT_JAN13:
                val = "JAN 13 / EAN 13";
                break;
            case ScannerConst.SCAN_SDT_TF:
                val = "2 of 5";
                break;
            case ScannerConst.SCAN_SDT_ITF:
                val = "Interleaved 2 of 5";
                break;
            case ScannerConst.SCAN_SDT_Codabar:
                val = "Codabar";
                break;
            case ScannerConst.SCAN_SDT_Code39:
                val = "Code 39";
                break;
            case ScannerConst.SCAN_SDT_Code93:
                val = "Code 93";
                break;
            case ScannerConst.SCAN_SDT_Code128:
                val = "Code 128";
                break;
            case ScannerConst.SCAN_SDT_UPCA_S:
                val = " UPC-A with Supplemental";
                break;
            case ScannerConst.SCAN_SDT_UPCE_S:
                val = "UPC-E with Supplemental";
                break;
            case ScannerConst.SCAN_SDT_UPCD1:
                val = "UPC-D1";
                break;
            case ScannerConst.SCAN_SDT_UPCD2:
                val = "UPC-D2";
                break;
            case ScannerConst.SCAN_SDT_UPCD3:
                val = "UPC-D3";
                break;
            case ScannerConst.SCAN_SDT_UPCD4:
                val = "UPC-D4";
                break;
            case ScannerConst.SCAN_SDT_UPCD5:
                val = "UPC-D5";
                break;
            case ScannerConst.SCAN_SDT_EAN8_S:
                val = "EAN-8 with Supplemental";
                break;
            case ScannerConst.SCAN_SDT_EAN13_S:
                val = "EAN-13 with Supplemental";
                break;
            case ScannerConst.SCAN_SDT_EAN128:
                val = "EAN-128";
                break;
            case ScannerConst.SCAN_SDT_OCRA:
                val = "OCR \"A\"";
                break;
            case ScannerConst.SCAN_SDT_OCRB:
                val = "OCR \"B\"";
                break;
            case ScannerConst.SCAN_SDT_PDF417:
                val = "PDF 417";
                break;
            case ScannerConst.SCAN_SDT_MAXICODE:
                val = "MAXICODE";
                break;
            case ScannerConst.SCAN_SDT_UNKNOWN:
                val = "Unknown";
                break;

            case ScannerConst.SCAN_SDT_OTHER:
                val = "Other";
                break;
        }
        return val;
    }
}
