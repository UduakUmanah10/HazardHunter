// ktlint-disable filename
package com.hazardhunt.safebuddy.login.domain.usecase

import com.hazardhunt.safebuddy.login.data.model.LoginResults
import com.hazardhunt.safebuddy.login.domain.util.Credentials

interface CredentialsLoginUsecase {
    /**
     * This function consumes a :
     * @param[credentials]
     * @return[LoginResults] that contains a LoginResponse if successful or an Error if not
     **/

    suspend operator fun invoke(
        credentials: Credentials,
    ): LoginResults
}
