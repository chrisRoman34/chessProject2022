import java.awt.image.BufferedImage;

public class King extends Piece{

    boolean deroque=false;

    public King(int x, int y, ColorChess c, boolean a, BufferedImage img) {
        super(x, y, c, a, img);
    }
    @Override
    public boolean movePossible(int x,int y){
        deroque=true;
        return (Math.abs(x-super.abscisse)== Math.abs(y-super.ordonnee)||super.abscisse==x || super.ordonnee==y)&&(Math.abs(x-super.abscisse)==75||75== Math.abs(y-super.ordonnee));
    }
}
