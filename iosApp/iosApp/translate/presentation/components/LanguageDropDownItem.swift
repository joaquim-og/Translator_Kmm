
import SwiftUI
import shared

struct LanguageDropDownItem: View {
    
    var language: UiLanguage
    var onClick: () -> Void
    
    var body: some View {
        Button(action: onClick) {
            HStack {
                if let image = UIImage(named: language.imageName.lowercased()) {
                    Image(uiImage: image)
                        .resizable()
                        .frame(width: 40, height: 40)
                        .padding(.trailing, 5)
                    Text(language.language.langName)
                        .foregroundColor(.lightBlue)
                }
            }
        }
    }
}

struct LanguageDropDownItem_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) { colorScheme in
            LanguageDropDownItem(
                language: UiLanguage(language: .czech, imageName: "czech"),
                onClick: {}
            )
            .preferredColorScheme(colorScheme)
        }
    }
}
