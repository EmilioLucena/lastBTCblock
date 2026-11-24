# lastBTCblock

**Understand what's happening on the Bitcoin network.**

lastBTCblock is a small Android app I developed out of an interest in the Bitcoin blockchain and the activity taking place behind each newly mined block. It is already available on Google Play.

The original idea was quite simple: retrieve the latest mined block, go through its transactions one by one, and watch the total amount of BTC accumulate as each transaction is processed.

## What the app does today

- Retrieves the latest mined Bitcoin block using the Blockchain.com API.
- Processes the transactions in that block individually.
- Displays the accumulated BTC output volume as transactions are processed.

One thing worth keeping in mind is that the total output volume does not necessarily represent how much BTC actually changed hands. Transaction outputs can include change and movements between wallets owned by the same person or entity.

## Where I'd like to take it

Knowing how much BTC moved in a block is interesting, but what does that number really tell us? Is it unusually high? How does it compare with previous blocks? Is something changing in the way the network is being used?

These are some of the questions I'd like the app to help answer.

Rather than building another Bitcoin price tracker, I'd like to turn lastBTCblock into a tool for exploring and understanding the activity of the Bitcoin network itself.

Some ideas for future development:

- Build a historical collection of block statistics.
- Identify blocks with unusually high transaction volumes or fees.
- Create historical rankings and compare activity over different periods.
- Explore changes in transaction patterns over time.
- Add charts and a more intuitive way to browse historical data.
- Improve the app's architecture, API integration, reliability and automated tests.

There are still some technical decisions to make, including whether historical data should be stored locally, on a backend, or both. Exploring these alternatives is part of the project.

## Building the app

Clone the repository:

```bash
git clone https://github.com/EmilioLucena/lastBTCblock.git
cd lastBTCblock
```

Open the project in Android Studio and let Gradle sync the dependencies.

The existing build configuration uses Android Gradle Plugin 8.8.1, Gradle 8.11.1 and Android SDK 36. JDK 17 is a suitable starting point.

To build a debug APK on Linux or macOS:

```bash
./gradlew assembleDebug
```

You'll need an internet connection to retrieve live blockchain data.

## License

lastBTCblock is open source under the [MIT License](LICENSE).

## A note on the data

This project is about understanding Bitcoin network activity, not predicting prices or providing trading signals. The information displayed by the app is intended for educational and informational purposes and should not be treated as investment advice.
