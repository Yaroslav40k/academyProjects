package com.andersen.stolenExamplesTests;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.andersen.stolenExamples.ApplicationRegistry;
import com.andersen.stolenExamples.AuthorizationService;
import com.andersen.stolenExamples.RequestLimitingService;
import com.andersen.stolenExamples.TokenService;
import com.andersen.stolenExamples.User;

public class AuthorizationServiceTest {
    private static final String TOKEN = "TESTTOKEN";
    private static final String APP_ID = "TESTAPP";

    final User u = new User();

    @Rule
    public EasyMockRule em = new EasyMockRule(this);

    @Mock
    private TokenService tokenService;

    @Mock
    private ApplicationRegistry applicationRegistry;

    @Mock
    private RequestLimitingService requestLimitingService;

    @TestSubject
    private AuthorizationService testedObject = new AuthorizationService();

    @Test
    public void testAuthorizeOk() {
        User u = new User();
        expect(tokenService.validateToken(TOKEN)).andStubReturn(u);
        expect(tokenService.getApplicationId(TOKEN)).andStubReturn(APP_ID);
        expect(applicationRegistry.validateApplicationId(APP_ID)).andStubReturn(true);
        expect(requestLimitingService.checkLimit(u, APP_ID)).andStubReturn(true);

        replay(tokenService, applicationRegistry, requestLimitingService);

        assertTrue(testedObject.authorize(TOKEN));
    }

    @Test
    public void testAuthorizeExtendedOk() {
        expect(tokenService.validateToken(TOKEN)).andStubReturn(u);
        expect(tokenService.getApplicationId(TOKEN)).andStubReturn(APP_ID);
        expect(applicationRegistry.validateApplicationId(APP_ID)).andStubReturn(true);
        expect(requestLimitingService.checkLimit(u, APP_ID)).andStubReturn(false);
        expect(requestLimitingService.checkExtendedLimit(u)).andStubReturn(true);

        replay(tokenService, applicationRegistry, requestLimitingService);

        assertTrue(testedObject.authorize(TOKEN));
    }

    //And so long....
}