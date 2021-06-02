package co.riiid.simpleboot

import com.google.protobuf.Timestamp
import org.lognet.springboot.grpc.GRpcService
import java.time.Instant

@GRpcService
class SimpleService: SimpleServiceGrpcKt.SimpleServiceCoroutineImplBase() {
    override suspend fun simpleGet(request: SimpleGetRequest): SimpleGetResponse {
        val time = Instant.now()

        return SimpleGetResponse
            .newBuilder()
            .setPayload1(1L)
            .setPayload2(Timestamp.newBuilder().setSeconds(time.epochSecond))
            .build()
    }
}
