package de.bundeswehr.graphics;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;


/**
 * Class represents and draws ellipses in a window.
 * The half axes of the ellipses run parallel to the cartesian coordinate system
 * underlying the window, whose origin is positioned in
 * its upper left corner.
 * 
 * The ellipse's position denotes the upper left corner of the (virtual) rectangle
 * which circumscribes the ellipse.
 * 
 * @author PSe
 */
public class Ellipse
{
    /** Length of horizontal axis */
    int horizontalLength;
    
    /** Length of vertical axis */
    int verticalLength;
    
    /** The x- and y-coordinates describing the ellipse's position, 
     * denoting the top left corner of its surrounding rectangle. */
    int xPos, yPos;
    
    /**
     * The ellipse's colour. 
     * Available colours are enumerated in Type Colour.
     */
    Colour colour;
    
    /**
     * Creates the ellipse, initializes all its attributes and draws it.
     * 
     * @param h Horizontal Length
     * @param v Vertical Length
     * @param x x-coordinate
     * @param y y-coordinate
     * @param initialColour Initial color
     */
    public Ellipse(int h, int v, int x, int y, Colour initialColour) {
        horizontalLength = h;
        verticalLength = v;
        xPos = x;
        yPos = y;
        colour = initialColour;
      }
  
    /**
     * Sets the ellipse's color to a new value and redraws the ellipse.
     * 
     * @param newColour
     */
     public void setColour(Colour newColour) {
         colour = newColour;
     }
     
     /**
      * Reset horizontalLength to a new value.
      * 
      * @param h New horizontal length.
      */
     public void setHorizontalLength(int h) {
    	 horizontalLength = h;
     }
     
     /**
      * Reset verticalLength to a new value.
      * 
      * @param v New vertical length.
      */
     public void setVerticalLength(int v) {
    	 verticalLength = v;
     }
     
     /**
      * Erases existing ellipse.
      * Moves the ellipse by resetting its coordinates.
      * Redraws moved ellipse.
      * 
      * @param xDelta Denotes horizontal movement
      * @param yDelta Denotes vertical movement
      */
      public void move(int xDelta, int yDelta) {
     	xPos = xPos + xDelta;
     	yPos = yPos + yDelta;
     }

    
    
    
    
    
    ///////////////////////////////////////////////////////////////////
    // Alles was ab hier kommt wurde in der Vorlesung nicht besprochen
    ///////////////////////////////////////////////////////////////////
    

    
    
    int getXPos() {
    	return this.xPos;
    }
    
    int getYPOS() {
    	return this.yPos;
    }
    
    
    
    
    public void draw()
    {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, colour, new Ellipse2D.Double(xPos, yPos, 
                                                          horizontalLength, verticalLength));
             canvas.wait(0);
    }

    public void erase()
    {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
    }
    
    private static class Canvas
    {
        // Note: The implementation of this class (specifically the handling of
        // shape identity and colors) is slightly more complex than necessary. This
        // is done on purpose to keep the interface and instance fields of the
        // shape objects in this project clean and simple for educational purposes.

        private static Canvas canvasSingleton;

        /**
         * Factory method to get the canvas singleton object.
         */
        public static Canvas getCanvas()
        {
            if(canvasSingleton == null) {
                canvasSingleton = new Canvas("Shawna das Schaf", 500, 300, 
                                             Color.white);
            }
            canvasSingleton.setVisible(true);
            return canvasSingleton;
        }

        //  ----- instance part -----

        private JFrame frame;
        private CanvasPane canvas;
        private Graphics2D graphic;
        private Color backgroundColor;
        private Image canvasImage;
        private java.util.List<Object> objects;
        private HashMap<Object, ShapeDescription> shapes;
        
        /**
         * Create a Canvas.
         * @param title    title to appear in Canvas Frame
         * @param width    the desired width for the canvas
         * @param height   the desired height for the canvas
         * @param bgColor the desired background color of the canvas
         */
        private Canvas(String title, int width, int height, Color bgColor)
        {
            frame = new JFrame();
            canvas = new CanvasPane();
            frame.setContentPane(canvas);
            frame.setTitle(title);
            frame.setLocation(30, 30);
            canvas.setPreferredSize(new Dimension(width, height));
            backgroundColor = bgColor;
            frame.pack();
            objects = new ArrayList<Object>();
            shapes = new HashMap<Object, ShapeDescription>();
        }

        /**
         * Set the canvas visibility and brings canvas to the front of screen
         * when made visible. This method can also be used to bring an already
         * visible canvas to the front of other windows.
         * @param visible  boolean value representing the desired visibility of
         * the canvas (true or false) 
         */
        public void setVisible(boolean visible)
        {
            if(graphic == null) {
                // first time: instantiate the offscreen image and fill it with
                // the background color
                Dimension size = canvas.getSize();
                canvasImage = canvas.createImage(size.width, size.height);
                graphic = (Graphics2D)canvasImage.getGraphics();
                graphic.setColor(backgroundColor);
                graphic.fillRect(0, 0, size.width, size.height);
                graphic.setColor(Color.black);
            }
            frame.setVisible(visible);
        }

        /**
         * Draw a given shape onto the canvas.
         * @param  referenceObject  an object to define identity for this shape
         * @param  color            the color of the shape
         * @param  shape            the shape object to be drawn on the canvas
         */
         // Note: this is a slightly backwards way of maintaining the shape
         // objects. It is carefully designed to keep the visible shape interfaces
         // in this project clean and simple for educational purposes.
        public void draw(Object referenceObject, Colour colour, Shape shape)
        {
            objects.remove(referenceObject);   // just in case it was already there
            objects.add(referenceObject);      // add at the end
            shapes.put(referenceObject, new ShapeDescription(shape, colour));
            redraw();
        }
     
        /**
         * Erase a given shape's from the screen.
         * @param  referenceObject  the shape object to be erased 
         */
        public void erase(Object referenceObject)
        {
            objects.remove(referenceObject);   // just in case it was already there
            shapes.remove(referenceObject);
            redraw();
        }

        /**
         * Set the foreground color of the Canvas.
         * @param  newColor   the new color for the foreground of the Canvas 
         */
        public void setForegroundColor(Colour colorString)
        {
        	switch (colorString) {
			case WHITE :
                graphic.setColor(Color.white);
                break;
			case YELLOW :
                graphic.setColor(new Color(255, 230, 0));
                break;
            case GREEN :
                graphic.setColor(new Color(80, 160, 60));
                break;
			case BLUE :
                graphic.setColor(new Color(30, 75, 220));
                break;
			case MAGENTA :
                graphic.setColor(Color.magenta);
                break;
			case RED : 
                graphic.setColor(new Color(235, 25, 25));
				break;
			case BLACK : 
                graphic.setColor(Color.black);
                break;
			default:
				graphic.setColor(Color.black);
			}
        }

        /**
         * Wait for a specified number of milliseconds before finishing.
         * This provides an easy way to specify a small delay which can be
         * used when producing animations.
         * @param  milliseconds  the number 
         */
        public void wait(int milliseconds)
        {
            try
            {
                Thread.sleep(milliseconds);
            } 
            catch (Exception e)
            {
                // ignoring exception at the moment
            }
        }

        /**
         * Redraw ell shapes currently on the Canvas.
         */
        private void redraw()
        {
            erase();
            for(Object shape : objects) {
                shapes.get(shape).draw(graphic);
            }
            canvas.repaint();
        }
           
        /**
         * Erase the whole canvas. (Does not repaint.)
         */
        private void erase()
        {
            Color original = graphic.getColor();
            graphic.setColor(backgroundColor);
            Dimension size = canvas.getSize();
            graphic.fill(new Rectangle(0, 0, size.width, size.height));
            graphic.setColor(original);
        }


        /************************************************************************
         * Inner class CanvasPane - the actual canvas component contained in the
         * Canvas frame. This is essentially a JPanel with added capability to
         * refresh the image drawn on it.
         */
        private class CanvasPane extends JPanel
        {
            private static final long serialVersionUID = 1L;

            public void paint(Graphics g)
            {
                g.drawImage(canvasImage, 0, 0, null);
            }
        }
        
        /************************************************************************
         * Inner class CanvasPane - the actual canvas component contained in the
         * Canvas frame. This is essentially a JPanel with added capability to
         * refresh the image drawn on it.
         */
        private class ShapeDescription
        {
            private Shape shape;
            private Colour colourString;

            public ShapeDescription(Shape shape, Colour colour)
            {
                this.shape = shape;
                colourString = colour;
            }

            public void draw(Graphics2D graphic)
            {
                setForegroundColor(colourString);
                graphic.fill(shape);
            }
        }

    }

    
}
