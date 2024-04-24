import java.awt.image.BufferedImage;

public class Tour extends Piece{

    public Tour(int x, int y, ColorChess c, boolean a, BufferedImage img) {
        super(x, y, c, a, img);
    }
    @Override
    public boolean movePossible(int x,int y){
        if(super.abscisse==x && super.ordonnee<y){
            for(int j=super.ordonnee+75;j<y;j=j+75){
                for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                    if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==j){
                        return false;
                    }
                }
            }
        }
        if(super.abscisse==x && super.ordonnee>y){
            for(int j=super.ordonnee-75;j>y;j=j-75){
                for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                    if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==j){
                        return false;
                    }
                }
            }
        }
        if(super.ordonnee==y && super.abscisse<x){
            for(int j=super.abscisse+75;j<x;j=j+75){
                for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                    if(GamePanel.listPiecesEnVie.get(i).getX()==j && GamePanel.listPiecesEnVie.get(i).getY()==y){
                        return false;
                    }
                }
            }
        }
        if(super.ordonnee==y && super.abscisse>x){
            for(int j=super.abscisse-75;j>x;j=j-75){
                for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                    if(GamePanel.listPiecesEnVie.get(i).getX()==j && GamePanel.listPiecesEnVie.get(i).getY()==y){
                        return false;
                    }
                }
            }
        }
        return super.abscisse==x || super.ordonnee==y;
    }
}
