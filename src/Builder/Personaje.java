package Builder;

import Strategy.Control;
import Strategy.Flechas;
import Vista.Vista1;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import Vista.Vista1;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Personaje extends JComponent implements Cloneable {

    protected ImageIcon[] derecha;
    protected ImageIcon[] izquierda;
    protected ImageIcon[] saltar;
    protected ImageIcon[] morir;
    protected ImageIcon[] atacar;
    protected Control ctr;
    static ImageIcon img;
    public int desplazamiento;
    public int tempDesplazamiento;
    int x = 0;
    int numero = 0;
    int ancho = 0;
    int alto = 0;
    int desplazamientoVertical = 0;
    int desplazamientoHorizontal = 0;
    int relacion = 0;
    public int velocidad;

    static JPanel panel;
    static JLabel Imagen = null;
    public Thread hilo;

    // CONSTRUCTOR
    public Personaje() {

        velocidad = 130;
        hilo = null;
        derecha = null;
        izquierda = null;
        saltar = null;
        morir = null;
        atacar = null;
        x = 0;
        numero = 0;
        ancho = 0;
        alto = 0;
        relacion = 0;

    }

    public int isRelacion() {
        return relacion;
    }

    public void setDesplazamientoVertical(int desplazamiento) {
        this.desplazamientoVertical = desplazamiento;
    }

    public void setDesplazamientoHorizontal(int desplazamiento) {
        this.desplazamientoHorizontal = desplazamiento;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void poder() throws IOException {
        img = new ImageIcon(ImageIO.read(new File("Recursos\\ImagenesOrco\\Izquierda\\OrcIzq1.jpg")));
        Imagen.setIcon(img);
    }

    public void setHilo(final int derecha, final int izquierda, final int saltar, final int morir, final int atacar, final int sleep) {
        this.hilo = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        switch (x) {
                            case 0:
                                switch (desplazamiento) {
                                    case 39:
                                        desplazamientoHorizontal += 24;
                                        tempDesplazamiento = desplazamiento;
                                        desplazamiento = 0;
                                        break;
                                    case 38:
                                        desplazamientoVertical -= 24;
                                        tempDesplazamiento = desplazamiento;
                                        desplazamiento = 0;
                                        break;
                                    case 37:
                                        desplazamientoHorizontal -= 24;
                                        tempDesplazamiento = desplazamiento;
                                        desplazamiento = 0;
                                        break;
                                    case 40:
                                        desplazamientoVertical += 24;
                                        tempDesplazamiento = desplazamiento;
                                        desplazamiento = 0;
                                        break;
                                    default:
                                        break;
                                }
                                numero++;
                                numero = numero % derecha;
                                panel.repaint();
                                hilo.sleep(velocidad);
                                System.out.println("velocidad: " + velocidad);
                                break;
                            case 1:
                                numero++;
                                numero = numero % saltar;
                                panel.repaint();
                                hilo.sleep(velocidad);
                                break;
                            case 2:
                                numero++;
                                numero = numero % morir;
                                panel.repaint();
                                hilo.sleep(velocidad);
                                break;
                            case 3:
                                numero++;
                                numero = numero % atacar;
                                panel.repaint();
                                hilo.sleep(velocidad);
                                break;
                            case 4:
                                numero++;
                                numero = numero % izquierda;
                                panel.repaint();
                                hilo.sleep(velocidad);
                                break;
                            default:
                                break;
                        }
                    }
                } catch (java.lang.InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
        setBounds(0, 0, panel.getWidth(), panel.getHeight());
    }

    public ImageIcon[] getDerecha() {
        return derecha;
    }

    public void setDerecha(ImageIcon[] derecha) {
        this.derecha = derecha;
    }

    public ImageIcon[] getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(ImageIcon[] izquierda) {
        this.izquierda = izquierda;
    }

    public ImageIcon[] getSaltar() {
        return saltar;
    }

    public void setSaltar(ImageIcon[] saltar) {
        this.saltar = saltar;
    }

    public ImageIcon[] getMorir() {
        return morir;
    }

    public void setMorir(ImageIcon[] morir) {
        this.morir = morir;
    }

    public ImageIcon[] getAtacar() {
        return atacar;
    }

    public void setAtacar(ImageIcon[] atacar) {
        this.atacar = atacar;
    }

    // CLONE
    @Override
    public Personaje clone() {
        Personaje PersonajeClonado = null;
        try {
            PersonajeClonado = (Personaje) super.clone();
            if (PersonajeClonado.isRelacion() == 1) {
                PersonajeClonado.setHilo(6, 6, 6, 5, 5, velocidad);
            } else if (PersonajeClonado.isRelacion() == 2) {
                PersonajeClonado.setHilo(5, 5, 3, 7, 5, velocidad);
            } else if (PersonajeClonado.isRelacion() == 3) {
                PersonajeClonado.setHilo(5, 6, 5, 4, 3, velocidad);
            }

        } catch (CloneNotSupportedException e) {
        }
        return PersonajeClonado;
    }

    // PINTAR EN PANEL
    @Override
    public void paint(Graphics g) {
        try {
            switch (x) {
                case 0:
                    g.drawImage(derecha[numero].getImage(), 50 + desplazamientoHorizontal, 0 + desplazamientoVertical, ancho, alto, null);
                    break;
                case 1:
                    g.drawImage(saltar[numero].getImage(), 50 + desplazamientoHorizontal, 0 + desplazamientoVertical, ancho, alto, null);
                    break;
                case 2:
                    g.drawImage(morir[numero].getImage(), 50 + desplazamientoHorizontal, 0 + desplazamientoVertical, ancho, alto - 18, null);
                    break;
                case 3:
                    g.drawImage(atacar[numero].getImage(), 50 + desplazamientoHorizontal, 0 + desplazamientoVertical, ancho, alto, null);
                    break;
                case 4:
                    g.drawImage(izquierda[numero].getImage(), 50 + desplazamientoHorizontal, 0 + desplazamientoVertical, ancho, alto, null);

                default:
                    break;
            }
        } catch (Exception ex) {

        }
    }

    // ANIMACIONES
    public void mover() {
        x = 0;
        if (!((tempDesplazamiento > 36) & (tempDesplazamiento < 41))) {
            numero = 0;
        }
        if (!hilo.isAlive()) {
            hilo.start();
        }
    }

    public void derecha() {
        x = 0;
        numero = 0;
        if (!hilo.isAlive()) {
            hilo.start();
        }
    }

    public void izquierda() {
        x = 4;
        numero = 0;
        if (!hilo.isAlive()) {
            hilo.start();
        }
    }

    public void saltar() {
        x = 1;
        numero = 0;
        if (!hilo.isAlive()) {
            hilo.start();
        }
    }

    public void morir() {
        x = 2;
        numero = 0;
        if (!hilo.isAlive()) {
            hilo.start();
        }
    }

    public void atacar() {
        x = 3;
        numero = 0;
        if (!hilo.isAlive()) {
            hilo.start();
        }
    }
    
     public void operar(KeyEvent evento) {
        ctr = new Flechas(evento, this);
        ctr.operar();
    }

    public void interrumpir() {
        try {
            hilo.interrupt();
        } catch (Exception ex) {
            System.out.println("hilo " + hilo.getName() + " no interrumpido");
        }
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getDesplazamientoHorizontal() {
        return desplazamientoHorizontal;
    }

    public int getDesplazamientoVertical() {
        return desplazamientoVertical;
    }

}
