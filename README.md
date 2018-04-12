# machine-learning-productionizing
This project shows how to use H20 and JPMML to load and use a prediction model created in another language.

### What problem does this address?
The typical creation of ML-Moldels starts with a data scientist creating the actual model in Python, R or Matlab on his machine.
When the model is evaluated to be sufficient given the projects requirements, a developer will rewrite the model to fit into
the actual production environment. This rewrite unfortunetly often leads to unintended side effects, bugs and costs time and money.

To streamline this process there are various steps a organisation can take. Lets me name a few:
+ Get the data scientists to write models in the preferred language of the developement team :thumbsdown:
+ Expose the model in a Webservice over REST (forces another app that has to monitored, etc. into the environment) :thumbsdown:
+ Package the models in language independent packages, so the models can be used in every supported language :thumbsup:

H2O and JPMML provide the means to package the models into language independent packages during creation, 
so that developers can just import and use the provided models.

The models used in this project are all random forest regressors trained on the boston housing market dataset from scikit-learn.

You can take a look at the jupyter notebook [here](https://github.com/carstendev/machine-learning-productionizing).
