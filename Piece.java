import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Piece{
    protected int abscisse;
    protected int ordonnee;
    protected ColorChess color;
    private boolean alive;
    private BufferedImage image;
    
    public Piece(int x,int y,ColorChess c,boolean a,BufferedImage img){
        abscisse=x;
        ordonnee=y;
        color=c;
        alive=a;
        image=img;
    }
    public boolean movePossible(int x,int y){
        return true;
    }
    public BufferedImage getImage(){
        return image;
    }
    public int getX(){
        return abscisse;
    }
    public int getY(){
        return ordonnee;
    }
    public void setX(int x){
        this.abscisse=x;
    }
    public void setY(int y){
        this.ordonnee=y;
    }
    public String getColor(){
        return color.name();
    }
    public boolean getAlive(){
        return alive;
    }
    
    public static BufferedImage resizeImage(java.awt.Image originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();

        // Utilisez des rendus lisses pour une meilleure qualité
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return resizedImage;
    }
}
