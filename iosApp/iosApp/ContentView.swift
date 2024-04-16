import SwiftUI
import shared

struct ContentView: View {
    
    private let appModule = AppModule()
    
    var body: some View {
        
        ZStack {
            Color.background
                .ignoresSafeArea()
            TranslateScreen(
                historyDatasource: appModule.historyDataSource,
                translateUseCase: appModule.translateUseCase
            )
        }
    }
}

