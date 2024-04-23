import SwiftUI
import shared

struct VoiceRecorderButton: View {
    var displayState: DisplayState
    var onCLick: () -> Void
    
    var body: some View {
        Button(action: onCLick) {
            ZStack {
                Circle()
                    .foregroundColor(.primaryColor)
                    .padding()
                icon
                    .foregroundColor(.onPrimary)
            }
        }
        .frame(maxWidth: 100, maxHeight: 100)
    }
}

extension VoiceRecorderButton {
    var icon: some View {
        switch displayState {
        case .speaking:
            return Image(systemName: "stop.fill")
        case .displayingResults:
            return Image(systemName: "checkmark")
        default:
            return Image(uiImage: UIImage(named: "mic")!)
        }
    }
}

struct VoiceRecorderButton_Previews: PreviewProvider {
    static var previews: some View {
        
        return ForEach(ColorScheme.allCases, id: \.self) { colorScheme in
            VoiceRecorderButton(
                displayState: .waitingToTalk,
                onCLick: {}
            )
            .preferredColorScheme(colorScheme)
        }
    }
}
