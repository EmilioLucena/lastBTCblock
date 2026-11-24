# lastBTCblock — Development Roadmap

## Motivation

The app currently retrieves information about the last mined Bitcoin block and shows the accumulated amount of BTC moved within that block, transaction by transaction.

Although this is interesting, I think we can make better use of the information available from the Bitcoin blockchain.

For instance, is the amount of BTC moved in a particular block unusually high? How does it compare to previous blocks? Can we identify changes in the way the Bitcoin network is being used?

To answer some of these questions, we will need historical data and some means of analyzing it.

The idea is not to predict the price of Bitcoin, but rather to have a better understanding of what is happening on the network.

I have identified six main areas to work on.

## 1. Data Acquisition

Estimated effort: 6–9 hours.

The app currently uses the blockchain.info API. However, we may need information that is not readily available from this API.

Some of the tasks I envisage are:

- Investigate other available APIs and compare them.
- Identify what information is readily available and what needs to be calculated.
- Investigate API limitations, historical data availability and eventual costs.
- Review the current implementation of the data acquisition layer.
- Try to make the app less dependent on a particular data provider.
- Investigate how relevant the total amount of BTC moved within a block actually is, considering the way Bitcoin transactions work.

At the end of this stage, we should have a better understanding of what data we can work with and how to retrieve it.

## 2. Historical Data and Persistence

Estimated effort: 12–18 hours.

In order to compare blocks and identify changes in network behavior, we will need to maintain historical data.

One point that still needs to be decided is whether the data should be kept locally or in a backend. There are advantages and disadvantages to both approaches.

The main tasks would be:

- Decide on the persistence strategy.
- Define what information needs to be stored. We may not need to keep all transactions of every block.
- Design and implement the database.
- Implement the initial population of historical data.
- Implement incremental data collection.
- Deal with missing blocks, duplicates and eventual blockchain reorganizations.
- Make sure we can resume the process after a failure or an interruption.
- Evaluate storage requirements and performance.

We should be able to maintain a consistent historical database without having to retrieve and process the same blocks over and over again.

## 3. Statistical Analysis

Estimated effort: 9–15 hours.

Once we have some historical data, we can start investigating what kind of useful information we can extract from it.

Some possibilities are:

- Rankings of blocks based on different criteria.
- Average and median amounts of BTC moved per block.
- Percentiles and distribution of transaction volumes.
- Comparison of network activity over different periods.
- Frequency and concentration of large transactions.
- Analysis of transaction fees and transaction counts.

One of the objectives here is to identify which of these indicators are actually relevant. Some may prove to be more useful than others.

This stage will probably involve some experimentation with real historical data.

## 4. Network Anomaly Detection

Estimated effort: 12–18 hours.

I believe this could become one of the most interesting features of the app.

Instead of just showing the amount of BTC moved in a block, we could inform the user that, for instance, the amount is higher than that of 99% of the blocks mined in the last 90 days.

We could also try to identify changes in network activity that are not necessarily related to a single block.

Some of the tasks would be:

- Investigate different approaches to detecting unusual network activity.
- Define what can be considered normal activity over a given period.
- Identify unusual transaction volumes, transaction counts and fees.
- Investigate changes in activity over a sequence of blocks.
- Evaluate the possibility of having an indicator that combines several metrics.
- Test the proposed methods against historical data.
- Investigate false positives and review the criteria used to identify anomalies.

At this point, I don't know which statistical methods will be more appropriate. This is something we will need to investigate during development.

## 5. Android Application Improvements

Estimated effort: 15–24 hours.

I would like to keep the original functionality of the app while introducing new ways of looking at the data.

The improvements could include:

- Review and refactoring of parts of the existing code.
- A new screen providing an overview of current network activity.
- Navigation through historical blocks.
- Rankings, charts and comparisons between blocks or periods.
- Presentation of unusual network events and why they are considered unusual.
- Notifications based on criteria that can be configured by the user.
- Local caching of relevant data.
- Better handling of connectivity issues and API failures.

The actual design of some of these features will depend on the results of the previous stages.

## 6. Quality, Reliability and Documentation

Estimated effort: 9–15 hours.

Considering that the app will be providing statistical information, we need to make sure that the underlying data and calculations are correct.

Some of the tasks are:

- Unit tests for data processing and statistical calculations.
- Creation of datasets that can be used to reproduce test scenarios.
- Tests involving incomplete data, API failures and interruptions during data collection.
- Verification of the consistency of historical data.
- Performance tests with larger datasets.
- Code review and refactoring where necessary.
- Documentation of the metrics and how they are calculated.
- Improvements to the project documentation and build instructions.
- Investigation of automated testing and continuous integration.

## Estimated Development Effort

| Area | Estimated hours |
|---|---:|
| Data acquisition | 6–9 |
| Historical data and persistence | 12–18 |
| Statistical analysis | 9–15 |
| Network anomaly detection | 12–18 |
| Android application improvements | 15–24 |
| Quality, reliability and documentation | 9–15 |
| **Total** | **63–99** |

These are initial estimates. They take into account not only the implementation itself, but also the investigation of alternatives, experimentation, testing, debugging and eventual refactoring.

Some of the tasks may take longer depending on the decisions we make along the way. We may also identify other possibilities as we become more familiar with the available data.

I expect the roadmap to evolve during the development of the project.
