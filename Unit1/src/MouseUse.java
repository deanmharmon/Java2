import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseUse extends MouseAdapter {
    int beginMouseX;
    int endMouseX;
    int beginMouseY;
    int endMouseY;

    @Override
    public void mousePressed(MouseEvent e){
        beginMouseX = e.getX();
        beginMouseY = e.getY();
    }
    @Override
    public void mouseReleased(MouseEvent e){
        endMouseX = e.getX();
        endMouseY = e.getY();
    }
    @Override
    public void mouseDragged(MouseEvent e){
        endMouseX = e.getX();
        endMouseY = e.getY();
    }
}
