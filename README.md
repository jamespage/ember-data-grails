ember-data-grails
=================

This repo sprung out of [my StackOverflow self-answer][so], with the goal to be more complete and easy-to-use.

[so]: http://stackoverflow.com/questions/15307576/how-to-make-ember-js-behave-with-grails-controller-names

## Using The Adapter

Just include `ember-data-grails.js`, and update your `App` definition so that it looks like this:

```javascript
App.Store = DS.Store.extend({
    revision: 12,
    adapter: DS.GrailsAdapter.create({
        namespace: 'grailsContext'
    })
});
```

For simple applications, you'll want to set `namespace` to the application context for your Grails application.  If you are using the root context, set it to an empty string.

## Grails Controller Modifications

The only modifications that are necessary to your JSON-serving Grails controllers are to set a root key to the name of the controller.  `ember-data` requires this to know what kind of data it's filling in.  I have included a utility class to do this, `RESTControllerAssistant.groovy`.

A simple example controller is included which makes use of this.

Also included is an example `UrlMappins.groovy`, which maps HTTP verbs to Controller actions.  This is necessary so that `POST /myCoolDomain/1` and `GET /myCoolDomain/1` do the correct thing.