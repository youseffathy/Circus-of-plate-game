package model.gameStrategy;

public class DifficultyFactory {
	private String[] difficulties;

	public DifficultyFactory() {
		difficulties = new String[] { "amateur", "semipro", "professional", "legendary"};
	}

	public GameStrategyIF getDifficulty(String diff) {
		if (diff.equals(difficulties[0])) {
			return new AmateurStrategy();
		}else if (diff.equals(difficulties[1])) {
			return new SemiproStrategy();
		}else if (diff.equals(difficulties[2])) {
			return new ProStrategy();
		}else if (diff.equals(difficulties[3])) {
			return new legendaryStrategy();
		}
		return new AmateurStrategy();

	}
}
