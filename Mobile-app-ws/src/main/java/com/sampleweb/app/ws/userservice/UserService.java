package com.sampleweb.app.ws.userservice;

import com.sampleweb.app.ws.ui.model.request.UserDataRequestJSON;
import com.sampleweb.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDataRequestJSON Req);

}
