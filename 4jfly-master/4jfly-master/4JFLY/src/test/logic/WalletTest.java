package test.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dkeep.logic.Wallet;

class WalletTest {
	
	@Test
	void InserWalletDeleteWalletPointsTestSuccess() {
		Wallet.Delete(2);
		assertEquals(-1, Wallet.Query_wallet_points("abel"));
		Wallet.Insert_wallet("abel", 2120);
		assertEquals(2120, Wallet.Query_wallet_points("abel"));
	}
	
	@Test
	void addPointsRemovePointsPointsTestSuccess() {
		Wallet.Add_points("abel", 100);
		assertEquals(2220, Wallet.Query_wallet_points("abel"));
		Wallet.Remove_points("abel", 100);
		assertEquals(2120, Wallet.Query_wallet_points("abel"));
	}
	
	
	@Test
	void queryWalletPointsTestWrongUser() {
		assertEquals(-1, Wallet.Query_wallet_points("abelo"));
	}
	
	@Test
	void queryWalletPointsTestSuccess() {
		assertEquals(2120, Wallet.Query_wallet_points("abel"));
	}
}
