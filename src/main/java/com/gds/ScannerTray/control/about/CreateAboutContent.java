package com.gds.ScannerTray.control.about;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.common.CreateJPanel;
import com.gds.ScannerTray.control.common.CreateLabel;
import com.gds.ScannerTray.control.common.GetGDSIcon;
import com.gds.ScannerTray.control.common.GetTrayIconPNG;
import com.gds.ScannerTray.control.common.SetFormLabelProperties;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateAboutContent {
    private final GetAppProperty appProperty = new GetAppProperty();

    public Container execute() {
        Container statusContent = createStatusContent();
        Container statusMainContent = createMainContent();
        statusMainContent.add(createIconContainerContent());
        statusMainContent.add(createCompanyInfoContent());
        statusContent.add(statusMainContent);
        return statusContent;
    }

    private JPanel createStatusContent() {
        BorderLayout statusPanelLayout = new BorderLayout();
        JPanel statusPanel = new CreateJPanel().execute(statusPanelLayout);
        statusPanel.setLayout(statusPanelLayout);
        statusPanel.add(createMainContent(), BorderLayout.CENTER);
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

    private JPanel createIconContainerContent() {
        GridLayout iconContainerContentLayout = new GridLayout();
        iconContainerContentLayout.setHgap(0);
        iconContainerContentLayout.setColumns(2);
        JPanel iconContainerContent = new CreateJPanel().execute(iconContainerContentLayout);
        iconContainerContent.add(createIconContent());
        iconContainerContent.add(createIcon2Content());
        return iconContainerContent;
    }

    private JPanel createIconContent() {
        BorderLayout iconContentLayout = new BorderLayout();
        JPanel iconContent = new CreateJPanel().execute(iconContentLayout);
        iconContentLayout.setHgap(30);
        iconContentLayout.setVgap(30);
        iconContent.setLayout(iconContentLayout);
        iconContent.add(new JLabel(new GetGDSIcon().execute()), BorderLayout.CENTER);
        return iconContent;
    }

    private JPanel createIcon2Content() {
        BorderLayout iconContentLayout = new BorderLayout();
        JPanel iconContent = new CreateJPanel().execute(iconContentLayout);
        iconContentLayout.setHgap(30);
        iconContentLayout.setVgap(30);
        iconContent.setLayout(iconContentLayout);
        iconContent.add(new JLabel(new GetTrayIconPNG().execute()), BorderLayout.CENTER);
        return iconContent;
    }

    private JPanel createCompanyInfoContent() {
        GridLayout companyInfoContentLayout = new GridLayout();
        companyInfoContentLayout.setColumns(1);
        companyInfoContentLayout.setRows(5);
        JPanel companyInfoContent = new CreateJPanel().execute(companyInfoContentLayout);
        companyInfoContent.add(new SetFormLabelProperties().execute(new CreateLabel().execute(appProperty.execute("APP_NAME"))));
        companyInfoContent.add(new CreateLabel().execute(appProperty.execute("LABEL_VERSION") + " " + appProperty.execute("APP_VERSION")));
        companyInfoContent.add(new CreateLabel().execute(appProperty.execute("LABEL_CP")));
        return companyInfoContent;
    }


}
