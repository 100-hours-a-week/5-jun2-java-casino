package casino;

import casino.controller.entrypoint.impl.EntrypointController;

public class Jun2CasinoApplication {
    public static void main(String[] args) {
        Jun2CasinoObjectContainer jun2CasinoObjectContainer = new Jun2CasinoObjectContainer();
        //  FIXME:  이 부분에서 모든 컨트롤러를 생성하고,
        //   컨테이너에 등록하는 작업을 수행하면 깔끔하게 떨어질거 같은데..?
        //   컨텍스트 클래스에 전부 주입 한 후에 컨텍스트 <-> 컨트롤러 (+리퀘스트, 리스폰스) <-> 서비스
        //   위 처럼 레이어 분류하면 initializeController 연쇄를 끊을 수 있어보임
        EntrypointController ctx = new EntrypointController(jun2CasinoObjectContainer);
        ctx.run();
    }
}
