package br.com.cgpp.vendas.utils;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicPanelUI;

/**
 *
 * @author Ugleiton
 */
public class PanelFormUICinza extends BasicPanelUI {

    private Color corInicial = new Color(255, 255, 255);
    private Color corFinal =  new Color(200, 200, 200);
    
    @Override
    protected void installDefaults(JPanel p) {
        p.setOpaque(true);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g;

        Dimension vSize = c.getSize();

        int h = vSize.height;
        int w = vSize.width;
        //g2.fillRect(0, 0, w, h);
        g2.setPaint(new GradientPaint(0, 0, corInicial, 0, h, corFinal));
        g2.fillRect(0, 0, w, h);

    }
}

