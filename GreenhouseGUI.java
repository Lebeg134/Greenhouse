import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;

import javax.swing.*;

public class GreenhouseGUI extends AgArch {
    JLabel labelTemp = new JLabel("Temp");
    JTextField tfTemp = new JTextField("", 15);

    JLabel labelOutTemp = new JLabel("Out Temp");
    JTextField tfOutTemp = new JTextField("", 15);

    JLabel labelHumidity = new JLabel("Humidity");
    JTextField tfHumidity = new JTextField("", 15);

    JLabel labelOutHumidity = new JLabel("Out Humid");
    JTextField tfOutHumidity = new JTextField("", 15);

    JLabel labelSoilWet = new JLabel("Soulwetness");
    JTextField tfSoilwet = new JTextField("", 15);

    JLabel labelBrightness = new JLabel("Brightness");
    JTextField tfBrightness = new JTextField("", 15);

    JLabel labelOutBrightness = new JLabel("Out Bright");
    JTextField tfOutBrightness = new JTextField("", 15);

    JLabel labelFertil = new JLabel("Fertilizer");
    JTextField tfFertil = new JTextField("", 15);

    JLabel window = new JLabel("Window state:");
    JLabel windowDisplay = new JLabel("-");

    JButton refresh = new JButton("Refresh");
    JButton apply = new JButton("Apply");

    List<JComponent> components = new ArrayList<>(Arrays.asList(
            labelTemp, tfTemp,
            labelOutTemp, tfOutTemp,
            labelHumidity, tfHumidity,
            labelOutHumidity, tfOutHumidity,
            labelSoilWet, tfSoilwet,
            labelBrightness, tfBrightness,
            labelOutBrightness, tfOutBrightness,
            labelFertil, tfFertil,
            window, windowDisplay
    ));


    JFrame frame;

    public GreenhouseGUI() {
        frame = new JFrame("Greenhouse Sim");
        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        contentPane.add(refresh);
        contentPane.add(apply);


        for (var c : components)
            contentPane.add(c);

        layout.putConstraint(SpringLayout.WEST, labelTemp, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelTemp, 5, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, tfTemp, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, tfTemp, 5, SpringLayout.NORTH, contentPane);

        for (int i = 2; i < components.size(); i += 2) {
            layout.putConstraint(SpringLayout.WEST, components.get(i), 5, SpringLayout.WEST, contentPane);
            layout.putConstraint(SpringLayout.NORTH, components.get(i), 5, SpringLayout.SOUTH, components.get(i - 1));

            layout.putConstraint(SpringLayout.WEST, components.get(i + 1), 100, SpringLayout.WEST, contentPane);
            layout.putConstraint(SpringLayout.NORTH, components.get(i + 1), 5, SpringLayout.SOUTH, components.get(i - 1));
        }

        layout.putConstraint(SpringLayout.WEST, refresh, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, refresh, 5, SpringLayout.SOUTH, window);

        layout.putConstraint(SpringLayout.WEST, apply, 5, SpringLayout.EAST, refresh);
        layout.putConstraint(SpringLayout.EAST, apply, -5, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, apply, 5, SpringLayout.SOUTH, window);

        layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, tfTemp);
        layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, apply);

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pullValuesFromEnviroment();
            }
        });
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pushValuesToEnviroment();
            }
        });


        frame.pack();
        frame.setVisible(true);
    }

    private void pushValuesToEnviroment() {
        Uveghaz u = Uveghaz.Instance;
        if (u == null) return;
        try {
            u.temperature = Integer.parseInt(tfTemp.getText());
            u.outtemperature = Integer.parseInt(tfOutTemp.getText());
            u.humidity = Integer.parseInt(tfHumidity.getText());
            u.outhumidity = Integer.parseInt(tfOutHumidity.getText());
            u.soilwetness = Integer.parseInt(tfSoilwet.getText());
            u.brightness = Integer.parseInt(tfBrightness.getText());
            u.outbrightness = Integer.parseInt(tfOutBrightness.getText());
            u.fertilization = Integer.parseInt(tfFertil.getText());
        } catch (Exception e) {
            System.out.println("Invalid format!");
        }
    }

    private void pullValuesFromEnviroment() {
        Uveghaz u = Uveghaz.Instance;
        if (u == null) return;
        tfTemp.setText("" + u.temperature);
        tfOutTemp.setText("" + u.outtemperature);
        tfHumidity.setText("" + u.humidity);
        tfOutHumidity.setText("" + u.outhumidity);
        tfSoilwet.setText("" + u.soilwetness);
        tfBrightness.setText("" + u.brightness);
        tfOutBrightness.setText("" + u.outbrightness);
        tfFertil.setText("" + u.fertilization);
        windowDisplay.setText(u.windowopen ? "Open" : "Closed");
    }




    @Override
    public void stop() {
        frame.dispose();
        super.stop();
    }
}
