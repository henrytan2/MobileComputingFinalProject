package com.ucdenver.puppylove.data.requests;
import com.ucdenver.puppylove.data.enums.WhyCreateAccountFailed;

public class User {
    static public class CreateAccountResponse {
        static private WhyCreateAccountFailed errorCode;

        public CreateAccountResponse() { }

        public WhyCreateAccountFailed getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(WhyCreateAccountFailed errorCode) {
            this.errorCode = errorCode;
        }
    }
}

