#Fetch Rewards Coding Exercise

## There are three states in the app:

### Loading State: This state is displayed when the user initially lands on the app. The app begins loading data from the server. Depending on the response, the app will transition to either the loaded state or the error state.
[loading state.webm](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/8707da63-fb6b-458b-9203-e3bc2ab63191)

### Loaded State: This state is displayed when the app has successfully loaded data from the server. The view model processes the data, converts the raw data into a valid format, and then displays a list of fetched items to the user. This is the final state of the app. 
![LoadedState](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/e15285cd-9a39-4ed7-9afc-6c5add7bbac4)

In case get empty list, app shows following message to user.
![loadedEmptyState](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/34b160e4-66e0-461d-a5b5-7ed4230c1345)

### Error State: This state is displayed when an error occurs during data loading (e.g., server down, no network connection). The app will show an alert dialog with a retry button. The user can press the retry button to reload the data. After retrying, the app will transition to either the loaded state or the error state based on the network response.
[error state.webm](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/28d4f3ea-8c9f-4e5f-a842-ae7170d7758e)
