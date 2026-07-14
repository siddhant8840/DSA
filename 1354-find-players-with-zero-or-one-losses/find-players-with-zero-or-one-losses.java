class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer, Integer> loss = new HashMap<>();

        // Count losses
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            // Add winner with 0 losses if not present
            if (!loss.containsKey(winner)) {
                loss.put(winner, 0);
            }

            // Increase loser's loss count
            if (loss.containsKey(loser)) {
                loss.put(loser, loss.get(loser) + 1);
            } else {
                loss.put(loser, 1);
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        ArrayList<Integer> players = new ArrayList<>(loss.keySet());

        // Separate players
        for (int i = 0; i < players.size(); i++) {
            int player = players.get(i);

            if (loss.get(player) == 0) {
                zeroLoss.add(player);
            } else if (loss.get(player) == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);

        return ans;
    }
}