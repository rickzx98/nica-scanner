package com.gds.ScannerTray.control.status;

import com.gds.BarcodeScanner.control.GetBarcodeScannerTypeName;
import com.gds.BarcodeScanner.control.GetScannerInstance;
import com.gds.Common.control.GetAppProperty;
import com.gds.Common.control.GetErrorLogger;
import com.gds.ScannerTray.control.common.*;
import jpos.JposException;
import jpos.Scanner;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class CreateStatusContent {
    private final GetErrorLogger errorLogger = new GetErrorLogger();
    private final GetAppProperty appProperty = new GetAppProperty();
    private final SetValueLabelProperties setValueLabelProperties = new SetValueLabelProperties();
    private final SetFormLabelProperties setFormLabelProperties = new SetFormLabelProperties();

    public Container execute() {
        Container statusContent = createStatusContent();
        JPanel statusMainContent = createMainContent();
        JPanel iconContent = createIconContent();
        JPanel deviceInfoContent = createDeviceInfoContent();

        statusMainContent.add(iconContent);
        statusMainContent.add(deviceInfoContent);
        statusContent.add(statusMainContent);
        return statusContent;
    }

    private JPanel createStatusContent() {
        BorderLayout statusPanelLayout = new BorderLayout();
        JPanel statusPanel = new CreateJPanel().execute(statusPanelLayout);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHgap(20);
        statusPanelLayout.setVgap(5);

        statusPanel.add(createMainContent(), BorderLayout.CENTER);
        statusPanel.add(new CreateJPanel().execute(null), BorderLayout.EAST);
        return statusPanel;
    }

    private JPanel createMainContent() {
        GridLayout mainContentLayout = new GridLayout();
        JPanel mainContent = new CreateJPanel().execute(mainContentLayout);
        mainContentLayout.setColumns(2);
        mainContentLayout.setRows(1);
        mainContent.setLayout(mainContentLayout);
        return mainContent;
    }

    private JPanel createIconContent() {
        BorderLayout iconContentLayout = new BorderLayout();
        JPanel iconContent = new CreateJPanel().execute(iconContentLayout);
        iconContentLayout.setHgap(30);
        iconContentLayout.setVgap(30);
        iconContent.setLayout(iconContentLayout);
        iconContent.add(new JLabel(new GetTrayIconPNG().execute()), BorderLayout.CENTER);
        return iconContent;
    }

    private JPanel createDeviceInfoContent() {
        Scanner scanner = new GetScannerInstance().execute();
        GridLayout deviceInfoContentLayout = new GridLayout();
        deviceInfoContentLayout.setColumns(2);
        deviceInfoContentLayout.setRows(5);
        JPanel deviceInfoContent = new CreateJPanel().execute(deviceInfoContentLayout);
        try {
            deviceInfoContent.add(setFormLabelProperties.execute(new CreateLabel().execute(appProperty.execute("LABEL_DEVICE_NAME") + ':')));
            deviceInfoContent.add(setValueLabelProperties.execute(new CreateLabel().execute(scanner.getPhysicalDeviceName())));

            deviceInfoContent.add(setFormLabelProperties.execute(new CreateLabel().execute(appProperty.execute("LABEL_DEVICE_DESCRIPTION") + ':')));
            deviceInfoContent.add(setValueLabelProperties.execute(new CreateLabel().execute(scanner.getPhysicalDeviceDescription())));

            deviceInfoContent.add(setFormLabelProperties.execute(new CreateLabel().execute(appProperty.execute("LABEL_SERVICE_DESCRIPTION") + ':')));
            deviceInfoContent.add(setValueLabelProperties.execute(new CreateLabel().execute(scanner.getDeviceServiceDescription())));

            deviceInfoContent.add(setFormLabelProperties.execute(new CreateLabel().execute(appProperty.execute("LABEL_SERVICE_VERSION") + ':')));
            deviceInfoContent.add(setValueLabelProperties.execute(new CreateLabel().execute(String.valueOf(scanner.getDeviceServiceVersion()))));

            deviceInfoContent.add(setFormLabelProperties.execute(new CreateLabel().execute(appProperty.execute("LABEL_STATUS") + ':')));
            deviceInfoContent.add(createStatusLabel(scanner));


        } catch (JposException e) {
            errorLogger.execute(CreateStatusContent.class, e.getMessage(), e);
        }
        return deviceInfoContent;
    }

    private JLabel createStatusLabel(Scanner scanner) throws JposException {
        JLabel statusLabel = new CreateLabel().execute(scanner.getDeviceEnabled() ? appProperty.execute("LABEL_RUNNING") : appProperty.execute("LABEL_STOPPED"));
        if (statusLabel.getText().equals(appProperty.execute("LABEL_RUNNING"))) {
            statusLabel.setForeground(new GetStatusRunningColor().execute());
        } else {
            statusLabel.setForeground(Color.PINK);
        }

        return setValueLabelProperties.execute(statusLabel);
    }

}
