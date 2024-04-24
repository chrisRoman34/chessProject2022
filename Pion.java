import java.awt.image.BufferedImage;

public class Pion extends Piece{

    boolean premierCoup=true;
    public Pion(int x, int y, ColorChess c, boolean a, BufferedImage img) {
        super(x, y, c, a, img);
    }
    @Override
    public boolean movePossible(int x,int y){
        if(x==super.abscisse){
            for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==y){
                    return false;
                }
            }
            if(super.color==color.BLACK){
                if(premierCoup){
                    if(y-super.ordonnee==2*(75)){
                        for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                            if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==y-75){
                                return false;
                            }
                        }
                        premierCoup=false;
                        return true;
                    }
                    else if(y-super.ordonnee==75){
                        premierCoup=false;
                        return true;
                    }
                    else{return false;}
                }
                else{
                    if(y-super.ordonnee==75){
                        return true;
                    }
                    else{return false;}
                }
            }

            else{
                if(premierCoup){
                    if(y-super.ordonnee==2*(-75)){
                        for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                            if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==y+75){
                                return false;
                            }
                        }
                        premierCoup=false;
                        return true;
                    }
                    else if(y-super.ordonnee==-75){
                        premierCoup=false;
                        return true;
                    }
                    else{return false;}
                }
                else{
                    if(y-super.ordonnee==-75){
                        return true;
                    }
                    else{return false;}
                }
            }
            
        }
        else{
            if(super.color==color.BLACK){
                if(y-super.ordonnee==75 && Math.abs(x-super.abscisse)==75){
                    boolean pieceIci2=false;
                    for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                        if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==y){
                            pieceIci2=true;
                            return true;
                        }
                    }
                    if(!pieceIci2){
                        return false;
                    }
                }
                else{return false;}
            }
            else{
                if(y-super.ordonnee==-75 && Math.abs(x-super.abscisse)==75){
                    boolean pieceIci2=false;
                    for(int i=0;i<GamePanel.listPiecesEnVie.size();i++){
                        if(GamePanel.listPiecesEnVie.get(i).getX()==x && GamePanel.listPiecesEnVie.get(i).getY()==y){
                            pieceIci2=true;
                            return true;
                        }
                    }
                    if(!pieceIci2){
                        return false;
                    }
                }
                else{return false;}
            }

        }
        return false;
    }
}
