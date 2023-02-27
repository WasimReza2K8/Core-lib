# Core-lib
It is a generic library for any android project. In this library, it contains BaseViewModel to implement UDF(Unidirectional Data Flow)+MVVM  architecture.
In MVI (Model, View, Intent) architecture user interaction regard as event (or user intent)
that change the model which represents UI state. ViewModel is responsible for creating immutable state
for the ui and hold them. I use shared flow for user events, compose state for states and state contains the view events.
User events are one time event that is why I usehot observable like shared flow. Shared flow can be observed from multiple 
subscribers for this reasonit is a better option to use it for users event (if we want multiple work starting with one event). 
However, view events e.g., error event, navigation events are going to be part of the state according to the google's recommandation
(https://medium.com/androiddevelopers/viewmodel-one-off-event-antipatterns-16a1da869b95).

The other packages contains some extention methods for different views. FragmentBinding delete and adapter delete is also part of it. 
