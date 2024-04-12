import SwiftUI
import shared

struct SwapLanguageButton: View {
    
    var onClick: () -> Void
    
    var body: some View {
        Button(action: onClick) {
            Image(uiImage: UIImage(named: "swap_languages")!)
                .padding()
                .background(Color.primaryColor)
                .clipShape(Circle())
        }
    }
}

struct LSwapLanguageButton_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) { colorScheme in
            SwapLanguageButton(onClick: {})
            .preferredColorScheme(colorScheme)
        }
    }
}
