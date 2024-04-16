import SwiftUI
import shared

struct LanguageDisplay: View {
    
    var language: UiLanguage
    
    var body: some View {
        HStack {
            SmallLanguageIcon(language: language)
                .padding(.trailing, 5)
            Text(language.language.langName)
                .foregroundColor(.lightBlue)
        }
    }
}

struct LanguageDisplay_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) { colorScheme in
            LanguageDisplay(language: UiLanguage(language: .czech, imageName: "czech"))
            .preferredColorScheme(colorScheme)
        }
    }
}
