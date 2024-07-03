#Fetch Rewards Coding Exercise

## There are three states in the app:

### Loading State: This state is displayed when the user initially lands on the app. The app begins loading data from the server. Depending on the response, the app will transition to either the loaded state or the error state.
[loading state.webm](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/8707da63-fb6b-458b-9203-e3bc2ab63191)

### Loaded State: This state is displayed when the app has successfully loaded data from the server. The view model processes the data, converts the raw data into a valid format, and then displays a list of fetched items to the user. This is the final state of the app. 
[loaded state.webm](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/e689e37b-a3cc-4388-a5ef-bac6f35f2c38)

### In case get empty list from server, app will show following message to user.
[loaded state empty list.webm](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/f02d2459-9120-4277-a7cc-c0a2153aaad4)

### Error State: This state is displayed when an error occurs during data loading (e.g., server down, no network connection). The app will show an alert dialog with a retry button. The user can press the retry button to reload the data. After retrying, the app will transition to either the loaded state or the error state based on the network response.
[error state.webm](https://github.com/KechengTao1205/FetchRewardsCodingExercise/assets/173308411/28d4f3ea-8c9f-4e5f-a842-ae7170d7758e)
