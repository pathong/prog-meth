package logic;

public class Fighter extends Piece{


    private boolean promoted;
    private PositionList promotedMovePositions;

    public Fighter(int initialX,int initialY, boolean reverse, String name){
        super(initialX,initialY,reverse,name);
        promotedMovePositions = new PositionList();
        ((PositionList)getMovePositions()).add(-1,2);
        ((PositionList)getMovePositions()).add(1,2);


        promotedMovePositions.add(0,2);
        promotedMovePositions.add(1,0);
        promotedMovePositions.add(0,-2);
        promotedMovePositions.add(-1,0);

        if(reverse){
            for(Position pos:getMovePositions()){
                pos.reverse();
            }
            for(Position pos:getPromotedMovePositions()){
                pos.reverse();
            }
        }

        setPromoted(false);


    }
    @Override
    public void move(int movePattern) {
        Position move = null;
        if(!promoted){
            move = getMovePositions().get(movePattern);
        }
        else{
            move = getPromotedMovePositions().get(movePattern);
        }

        getCurrentPosition().normalizedPosition();
        setCurrentPosition(getCurrentPosition().addPositionValue(move));
    }

    @Override
    public Position attackTargetPosition(int actionPattern) {
        Position actionPos= null;
        if(!promoted){
            actionPos= getMovePositions().get(actionPattern);
        }
        else{
            actionPos= getPromotedMovePositions().get(actionPattern);
        }
        getCurrentPosition().normalizedPosition();
        setCurrentPosition(getCurrentPosition().addPositionValue(actionPos));

        return getCurrentPosition();
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public PositionList getPromotedMovePositions() {
        return promotedMovePositions;
    }

    public void setPromotedMovePositions(PositionList promotedMovePositions) {
        this.promotedMovePositions = promotedMovePositions;
    }
}
