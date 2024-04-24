import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = SCREEN_HEIGHT/8;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 150;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    boolean running = false;
    Timer timer;
    static public ArrayList<Piece> listPiecesEnVie = new ArrayList<Piece>();
    BufferedImage imgCBN=ImageIO.read(new File("cavalier-1.png"));
    BufferedImage imgQBN=ImageIO.read(new File("queen-1.png"));
    BufferedImage imgKBN=ImageIO.read(new File("king-1.png"));
    BufferedImage imgFBN=ImageIO.read(new File("fou-1.png"));
    BufferedImage imgTBN=ImageIO.read(new File("tour-1.png"));
    BufferedImage imgPBN=ImageIO.read(new File("pion-1.png"));
    BufferedImage imgCNN=ImageIO.read(new File("cavalierN-1.png"));
    BufferedImage imgQNN=ImageIO.read(new File("queenN-1.png"));
    BufferedImage imgKNN=ImageIO.read(new File("kingN-1.png"));
    BufferedImage imgFNN=ImageIO.read(new File("fouN-1.png"));
    BufferedImage imgTNN=ImageIO.read(new File("tourN-1.png"));
    BufferedImage imgPNN=ImageIO.read(new File("pionN-1.png"));
    BufferedImage imgPionB = resizeImage(imgPBN,600/11, 600/9);
    BufferedImage imgTourB = resizeImage(imgTBN,600/11, 600/9);
    BufferedImage imgFouB = resizeImage(imgFBN,600/11, 600/9);
    BufferedImage imgCavalierB = resizeImage(imgCBN,600/11, 600/9);
    BufferedImage imgQueenB = resizeImage(imgQBN,600/11, 600/9);
    BufferedImage imgKingB = resizeImage(imgKBN,600/11, 600/9);
    BufferedImage imgPionN = resizeImage(imgPNN,600/11, 600/9);
    BufferedImage imgTourN = resizeImage(imgTNN,600/11, 600/9);
    BufferedImage imgFouN = resizeImage(imgFNN,600/11, 600/9);
    BufferedImage imgCavalierN = resizeImage(imgCNN,600/11, 600/9);
    BufferedImage imgQueenN = resizeImage(imgQNN,600/11, 600/9);
    BufferedImage imgKingN = resizeImage(imgKNN,600/11, 600/9);
    int mouseX=0;
    int mouseY=0;
    boolean select=false;
    int pieceSelect;
    static public int kingNX=4*UNIT_SIZE+10;
    static public int kingNY=0;
    static public int kingBX=4*UNIT_SIZE+10;
    static public int kingBY=7*UNIT_SIZE;

    
    GamePanel()throws IOException {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addMouseListener(new MouseAdapter() {
        @Override 
        public void mousePressed(MouseEvent e) {
          mouseX=UNIT_SIZE*(e.getX()/UNIT_SIZE)+10;
          mouseY=UNIT_SIZE*(e.getY()/UNIT_SIZE);
          pieceSurCase();
        }});
        newGame();
        startGame();

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
    public void startGame(){
        running = true;
        timer= new Timer(DELAY,this);
        timer.start();

    }

    public void pieceSurCase(){
        if(!select){
            for(int i=0;i<listPiecesEnVie.size();i++){
                if(listPiecesEnVie.get(i).getX()==mouseX && listPiecesEnVie.get(i).getY()==mouseY){
                    select=true;
                    pieceSelect=i;
                    
                }
            }
        }
        else{
            Piece p=listPiecesEnVie.get(pieceSelect);
            if(p.movePossible(mouseX, mouseY)){
                boolean pieceIci=false;
                for(int i=0;i<listPiecesEnVie.size();i++){
                    if(mouseX==listPiecesEnVie.get(i).getX() && mouseY==listPiecesEnVie.get(i).getY()){
                        if(listPiecesEnVie.get(i).getColor()!=p.getColor()){
                            p.setX(mouseX);
                            p.setY(mouseY);
                            select=false;
                            listPiecesEnVie.remove(i);
                        }
                        else{
                            select=false;
                            pieceIci=true;
                        }
                    }
                }
                if(!pieceIci){
                    p.setX(mouseX);
                    p.setY(mouseY);
                    select=false;
                }
            }
            else{
                select=false;
            }
        }

    }
    public void newGame() {
        for(int i=0;i<8;i++){
            listPiecesEnVie.add(new Pion(i*UNIT_SIZE+10, UNIT_SIZE, ColorChess.BLACK, true,imgPionN));
        }
        for(int i=8;i<16;i++){
            listPiecesEnVie.add(new Pion((i-8)*UNIT_SIZE+10, 6*UNIT_SIZE, ColorChess.WHITE, true,imgPionB));
        }
        listPiecesEnVie.add(new Tour(10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgTourB));
        listPiecesEnVie.add(new Tour(7*UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgTourB));
        listPiecesEnVie.add(new Fou(2*UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgFouB));
        listPiecesEnVie.add(new Fou(5*UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgFouB));
        listPiecesEnVie.add(new Cavalier(UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgCavalierB));
        listPiecesEnVie.add(new Cavalier(6*UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgCavalierB));
        listPiecesEnVie.add(new Queen(3*UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgQueenB));
        listPiecesEnVie.add(new King(4*UNIT_SIZE+10, 7*UNIT_SIZE, ColorChess.WHITE, true,imgKingB));
        listPiecesEnVie.add(new Tour(10, 0, ColorChess.BLACK, true,imgTourN));
        listPiecesEnVie.add(new Tour(7*UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgTourN));
        listPiecesEnVie.add(new Fou(2*UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgFouN));
        listPiecesEnVie.add(new Fou(5*UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgFouN));
        listPiecesEnVie.add(new Cavalier(UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgCavalierN));
        listPiecesEnVie.add(new Cavalier(6*UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgCavalierN));
        listPiecesEnVie.add(new Queen(3*UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgQueenN));
        listPiecesEnVie.add(new King(4*UNIT_SIZE+10, 0, ColorChess.BLACK, true,imgKingN));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for(int i=0;i<8;i++){ 
            for(int j=0;j<8;j++){
                if((i+j)%2==0){
                    g.setColor(Color.WHITE);
                    g.fillRect(i*UNIT_SIZE, j*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
        g.drawImage(listPiecesEnVie.get(0).getImage(),listPiecesEnVie.get(0).getX(),listPiecesEnVie.get(0).getY(),null);
        for(int i=0;i<listPiecesEnVie.size();i++){
            g.drawImage(listPiecesEnVie.get(i).getImage(),listPiecesEnVie.get(i).getX(),listPiecesEnVie.get(i).getY(),null);
        }
        if(select){
            g.setColor(Color.GREEN);
            g.drawRect(mouseX-10, mouseY, UNIT_SIZE, UNIT_SIZE);
            g.drawRect(mouseX-9, mouseY+1, UNIT_SIZE-2, UNIT_SIZE-2);
        }
    }
        
    public void GameOver(Graphics g){
        
    }
    public void supPiece(int x, int y){
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        //Point p = MouseInfo.getPointerInfo().getLocation();
        repaint();
    }
}