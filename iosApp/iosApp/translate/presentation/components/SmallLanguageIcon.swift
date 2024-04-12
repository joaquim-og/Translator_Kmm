import SwiftUI
import shared

struct SmallLanguageIcon: View {
    
    var language: UiLanguage
    
    var body: some View {
        Image(uiImage: UIImage(named: language.imageName.lowercased())!)
            .resizable()
            .frame(width: 30, height: 30)
    }
}

struct SmallLanguageIcon_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) { colorScheme in
            SmallLanguageIcon(language: UiLanguage(language: .czech, imageName: "czech"))
            .preferredColorScheme(colorScheme)
        }
    }
}
