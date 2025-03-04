package com.zionhuang.innertube.models.response

import com.zionhuang.innertube.models.AccountInfo
import com.zionhuang.innertube.models.Runs
import kotlinx.serialization.Serializable

@Serializable
data class AccountMenuResponse(
    val actions: List<Action>,
) {
    @Serializable
    data class Action(
        val openPopupAction: OpenPopupAction,
    ) {
        @Serializable
        data class OpenPopupAction(
            val popup: Popup,
        ) {
            @Serializable
            data class Popup(
                val multiPageMenuRenderer: MultiPageMenuRenderer,
            ) {
                @Serializable
                data class MultiPageMenuRenderer(
                    val header: Header?,
                ) {
                    @Serializable
                    data class Header(
                        val activeAccountHeaderRenderer: ActiveAccountHeaderRenderer,
                    ) {
                        @Serializable
                        data class ActiveAccountHeaderRenderer(
                            val accountName: Runs,
                            val email: Runs,
                        ) {
                            fun toAccountInfo() = AccountInfo(
                                accountName.runs!!.first().text,
                                email.runs!!.first().text
                            )
                        }
                    }
                }
            }
        }
    }
}
