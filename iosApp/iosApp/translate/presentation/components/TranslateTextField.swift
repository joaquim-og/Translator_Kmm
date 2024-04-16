import SwiftUI
import shared
import UniformTypeIdentifiers

struct TranslateTextField: View {
    
    @Binding var fromText: String
    var toText: String?
    var isTranslating: Bool
    var fromLanguage: UiLanguage
    var toLanguage: UiLanguage
    var onTranslateEvent: (TranslateEvent) -> Void
    
    var body: some View {
        if (toText == nil || isTranslating) {
            idleTextField(
                fromText: $fromText,
                isTranslating: isTranslating,
                onTranslateEvent: onTranslateEvent
            )
            .gradientSurface()
            .cornerRadius(15)
            .animation(.easeInOut, value: isTranslating)
            .shadow(radius: 4)
        } else {
            translateTextField(
                fromText: fromText,
                toText: toText ?? "",
                fromLanguage: fromLanguage,
                toLanguage: toLanguage,
                onTranslateEvent: onTranslateEvent
            )
            .padding()
            .gradientSurface()
            .cornerRadius(15)
            .animation(.easeInOut, value: isTranslating)
            .shadow(radius: 4)
            .onTapGesture {
                onTranslateEvent(TranslateEvent.EditTranslation())
            }
        }
    }
}


struct TranslateTextField_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) { colorScheme in
            TranslateTextField(
                fromText: Binding(get: {"Test"}, set: {_ in}),
                toText: "TExt",
                isTranslating: false,
                fromLanguage: UiLanguage(language: .english, imageName: "english"),
                toLanguage: UiLanguage(language: .czech, imageName: "czech"),
                onTranslateEvent: {_ in}
            )
            .preferredColorScheme(colorScheme)
        }
    }
}

private extension TranslateTextField {
    
    struct idleTextField: View {
        
        @Binding var fromText: String
        var isTranslating: Bool
        var onTranslateEvent: (TranslateEvent) -> Void
        
        
        var body: some View {
            TextEditor(text: $fromText)
                .frame(
                    maxWidth: .infinity,
                    minHeight: 200,
                    alignment: .topLeading
                )
                .padding()
                .foregroundColor(Color.onSurface)
                .overlay(alignment: .bottomTrailing) {
                    ProgressButton(
                        text: "Translate",
                        isLoading: isTranslating,
                        onClick: {
                            onTranslateEvent(TranslateEvent.Translate())
                        }
                    )
                    .padding(.trailing)
                    .padding(.bottom)
                }
                .onAppear{
                    UITextView.appearance().backgroundColor = .clear
                }
        }
    }
    
    struct translateTextField: View {
        
        var fromText: String
        var toText: String
        var fromLanguage: UiLanguage
        var toLanguage: UiLanguage
        var onTranslateEvent: (TranslateEvent) -> Void
        
        private let tts = TextToSpeech()
        
        var body: some View {
            VStack(
                alignment: .leading,
                content: {
                    LanguageDisplay(language: fromLanguage)
                    Text(fromText)
                        .foregroundColor(.onSurface)
                    HStack {
                        Spacer()
                        Button(
                            action: {
                                UIPasteboard.general.setValue(
                                    fromText,
                                    forPasteboardType: UTType.plainText.identifier
                                )
                            }
                        ) {
                            Image(uiImage: UIImage(named: "copy")!)
                                .renderingMode(.template)
                                .foregroundColor(.lightBlue)
                        }
                        Button(
                            action: {
                                onTranslateEvent(TranslateEvent.CloseTranslation())
                            }
                        ) {
                            Image(systemName: "xmark")
                                .foregroundColor(.lightBlue)
                        }
                    }
                    Divider()
                        .padding()
                    LanguageDisplay(language: toLanguage)
                        .padding(.bottom)
                    Text(toText)
                        .foregroundColor(.onSurface)
                    HStack {
                        Spacer()
                        Button(
                            action: {
                                UIPasteboard.general.setValue(
                                    toText,
                                    forPasteboardType: UTType.plainText.identifier
                                )
                            }
                        ) {
                            Image(uiImage: UIImage(named: "copy")!)
                                .renderingMode(.template)
                                .foregroundColor(.lightBlue)
                        }
                        Button(
                            action: {
                                tts.speak(
                                    text: toText,
                                    language: toLanguage.language.langCode
                                )
                            }
                        ) {
                            Image(systemName: "speaker.wave.2")
                                .foregroundColor(.lightBlue)
                        }
                    }
                }
            )
        }
    }
    
}
