package li.raymond.raymocloud.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;

import li.raymond.raymocloud.preferences.AppPreferences;
import li.raymond.raymocloud.preferences.AppPreferencesImpl;
import com.owncloud.android.AbstractIT;
import com.owncloud.android.lib.common.accounts.AccountUtils;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserAccountManagerImplTest extends AbstractIT {

    private AccountManager accountManager;

    @Before
    public void setUp() {
        accountManager = AccountManager.get(targetContext);
    }

    @Test
    public void updateOneAccount() {
        AppPreferences appPreferences = AppPreferencesImpl.fromContext(targetContext);
        UserAccountManagerImpl sut = new UserAccountManagerImpl(targetContext, accountManager);
        assertEquals(1, sut.getAccounts().length);
        assertFalse(appPreferences.isUserIdMigrated());

        Account account = sut.getAccounts()[0];

        // for testing remove userId
        accountManager.setUserData(account, AccountUtils.Constants.KEY_USER_ID, null);
        assertNull(accountManager.getUserData(account, AccountUtils.Constants.KEY_USER_ID));

        boolean success = sut.migrateUserId();
        assertTrue(success);

        Bundle arguments = androidx.test.platform.app.InstrumentationRegistry.getArguments();
        String userId = arguments.getString("TEST_SERVER_USERNAME");

        // assume that userId == loginname (as we manually set it)
        assertEquals(userId, accountManager.getUserData(account, AccountUtils.Constants.KEY_USER_ID));
    }
}
