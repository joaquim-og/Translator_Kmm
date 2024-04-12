import SwiftUI
import shared

struct TranslateScreen: View {
    
    private var historyDatasource: HistoryDataSource
    private var translateUseCase: TranslateUseCase
    
    @ObservedObject var viewModel: IOSTranslateViewModel
    
    init(
        historyDatasource: HistoryDataSource,
        translateUseCase: TranslateUseCase
    ) {
        self.historyDatasource = historyDatasource
        self.translateUseCase = translateUseCase
        self.viewModel = IOSTranslateViewModel(
            historyDataSource: historyDatasource,
            translateUseCase: translateUseCase
        )
    }
    
    var body: some View {
        ZStack {
            List {
                HStack(
                    alignment: .center,
                    content: {
                        LanguageDropDown(
                            language: viewModel.state.fromLanguage,
                            isOpen: viewModel.state.isChoosingFromLanguage,
                            selectLanguage: { language in
                                viewModel.onEvent(event: TranslateEvent.ChooseFromLanguage(language: language))
                            }
                        )
                        Spacer()
                        SwapLanguageButton(
                            onClick: {
                                viewModel.onEvent(event: TranslateEvent.SwapChoosingLanguage())
                                
                            }
                        )
                        Spacer()
                        LanguageDropDown(
                            language: viewModel.state.toLanguage,
                            isOpen: viewModel.state.isChoosingToLanguage,
                            selectLanguage: { language in
                                viewModel.onEvent(event: TranslateEvent.ChooseToLanguage(language: language))
                            }
                        )
                    }
                )
                .listRowSeparator(.hidden)
                .listRowBackground(Color.background)
            }
            .listStyle(.plain)
            .buttonStyle(.plain)
        }.onAppear{
            viewModel.startObserving()
        }.onDisappear{
            viewModel.dispose()
        }
    }
}
