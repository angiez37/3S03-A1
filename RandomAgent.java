import java.util.*;

public class RandomAgent implements CatanAgent {
    private int playerId;
    private Random random = new Random();

    @Override
    public void init(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public Move chooseMove(GameState state) {
        // Assuming that the core module provides a list of valid moves in the GameState
        List<Move> legalMoves = state.getLegalMoves(this.playerId);
        
        // If no moves are possible, then end the turn
        if (legalMoves.isEmpty()) {
            return new Move(Action.END_TURN);
        }
        // Pick a random move to test if the agent handles execution correctly
        return legalMoves.get(random.nextInt(legalMoves.size()));
    }

    @Override
    public Move chooseInitialSettlement(GameState state) {
        List<Move> validSpots = state.getValidInitialSettlementNodes();
        return validSpots.get(random.nextInt(validSpots.size()));
    }

    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) {
        // Pick random cards from the player's hand until discardCount is met
        Map<ResourceType, Integer> hand = state.getPlayerHand(this.playerId);
        Map<ResourceType, Integer> toDiscard = new HashMap<>();
        // handle cards that should be discarded here
        return toDiscard;
    }

    // All methods would follow the same pattern of checking the state for possible options and returning a random output    
    @Override public Move chooseInitialRoad(GameState state) { return state.getLegalRoads(playerId).get(0); }
    @Override public ResourceType chooseResource(GameState state) { return ResourceType.values()[random.nextInt(5)]; }
    @Override public int chooseRobberTarget(GameState state, List<Integer> targets) { return targets.get(0); }
    @Override public DevelopmentCard chooseDevelopmentCard(GameState state) { return null; /* Simple stub */ }
}