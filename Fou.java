
import java.awt.image.BufferedImage;

public class Fou extends Piece{

    public Fou(int x, int y, ColorChess c, boolean a, BufferedImage img) {
        super(x, y, c, a, img);
    }
    @Override

    public boolean movePossible(int x,int y){
        if(Math.abs(x-super.abscisse)== Math.abs(y-super.ordonnee)){
            if(super.abscisse>x && super.ordonnee>y){
                for(int j=-75;j+super.ordonnee>y;j=j-75){
                    for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                        if(GamePanel.listPiecesEnVie.get(i).getX()==j+super.abscisse && GamePanel.listPiecesEnVie.get(i).getY()==j+super.ordonnee){
                            return false;
                        }
                    }
                }
            }
            if(super.abscisse<x && super.ordonnee<y){
                for(int j=75;j+super.ordonnee<y;j=j+75){
                    for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                        if(GamePanel.listPiecesEnVie.get(i).getX()==j+super.abscisse && GamePanel.listPiecesEnVie.get(i).getY()==j+super.ordonnee){
                            return false;
                        }
                    }
                }
            }
            if(super.abscisse>x && super.ordonnee<y){
                for(int j=75;j+super.ordonnee<y;j=j+75){
                    for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                        if(GamePanel.listPiecesEnVie.get(i).getX()==-j+super.abscisse && GamePanel.listPiecesEnVie.get(i).getY()==j+super.ordonnee){
                            return false;
                        }
                    }
                }
            }
            if(super.abscisse<x && super.ordonnee>y){
                for(int j=-75;j+super.ordonnee>y;j=j-75){
                    for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                        if(GamePanel.listPiecesEnVie.get(i).getX()==-j+super.abscisse && GamePanel.listPiecesEnVie.get(i).getY()==j+super.ordonnee){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
