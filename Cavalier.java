import java.awt.image.BufferedImage;

public class Cavalier extends Piece{

    public Cavalier(int x, int y, ColorChess c, boolean a, BufferedImage img) {
        super(x, y, c, a, img);
    }
    @Override
    public boolean movePossible(int x,int y){
        if(x==super.abscisse+2*75 && (y==super.ordonnee+75 || y==super.ordonnee-75)){
            return true;
        }
        else if(x==super.abscisse-2*75 && (y==super.ordonnee+75 || y==super.ordonnee-75)){
            return true;
        }
        else if(y==super.ordonnee+2*75 && (x==super.abscisse+75 || x==super.abscisse-75)){
            return true;
        }
        else if(y==super.ordonnee-2*75 && (x==super.abscisse+75 || x==super.abscisse-75)){
            return true;
        }
        else{return false;}
    }
}
