package com.market.exception

import java.lang.RuntimeException

sealed class SeverException(
    val code: Int,
    override val message: String,
) : RuntimeException(message)


data class NotFoundException(
    override val message: String,
) : SeverException(404, message)

data class UnauthorizedException(
    override val message: String = "인증 정보가 잘못되었습니다.",
) : SeverException(401, message)

data class MarketBoardIdNotFoundException(
    override val message: String = "마켓보드가 존재 하지 않습니다.",
) : SeverException(402, message)

data class MismatchedMarketBoardUserException(
    override val message: String = "마켓보드의 유저가 일치하지 않습니다. ",
) : SeverException(404, message)