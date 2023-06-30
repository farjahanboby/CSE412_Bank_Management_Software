package practice.main1;

public interface IBaseRate {
	// method that returns the base rate
	default double getBaseRate() {
		return 2.5;
	}
}
