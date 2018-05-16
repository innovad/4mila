export class GuiModel {

    private _guiModel = {
        "application": {
            "title": "4mila",
            "formList": [
                {
                    "id": "OwnUserForm",
                    "title": "NotImplemented",
                    "formFieldList": [
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "EventForm",
                    "title": "Event",
                    "url": "/event",
                    "formFieldList": [
                        {
                            "id": "name",
                            "type": "text",
                            "name": "Name",
                            "required": true,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "ControlForm",
                    "title": "Control",
                    "url": "/control",
                    "formFieldList": [
                        {
                            "id": "id",
                            "type": "text",
                            "name": "Number",
                            "required": true,
                            "width": 2
                        },
                        {
                            "id":   "event",
                            "type": "autocomplete",
                            "name": "Event",
                            "wordSearchEnabled": true,
                            "defaultKey": "eventKey",
                            "required": true,
                            "readonly": true,
                            "form": "EventForm",
                            "url": "/event",
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
            ],
            "pageList": [
                {
                    "id": "mainmenu",
                    "name": "MainMenu",
                    "elementList": [
                        {
                            "type": "button",
                            "name": "Entry",
                            "icon": "fa-address-card",
                            "color": "carrot",
                            "page": "entriespage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Results",
                            "icon": "fa-list-ol",
                            "color": "pomegranate",
                            "page": "resultspage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Admin",
                            "icon": "fa-cog",
                            "color": "concrete",
                            "page": "adminpage",
                        },
                    ]
                },
                {
                    "id": "adminpage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewEvent",
                            "width": 2,
                            "icon": "fa-calendar",
                            "color": "green",
                            "form": {
                                "form": "EventForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-calendar",
                            "color": "belize hole",
                            "search": false,
                            "url": "/event",
                            "page": "eventpage"
                        }
                    ]
                },
                {
                    "id": "eventpage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "EditEvent",
                            "width": 2,
                            "icon": "fa-calendar",
                            "color": "green",
                            "form": {
                                "form": "EventForm"
                            }
                        },
                        {
                            "type": "button",
                            "name": "Courses",
                            "icon": "fa-map",
                            "color": "carrot",
                            "page": "entriespage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Classes",
                            "icon": "fa-users",
                            "color": "carrot",
                            "page": "entriespage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "list",
                            "name": "Controls",
                            "icon": "fa-map-pin",
                            "color": "carrot",
                            "search": false,
                            "url": "/event/:eventKey/control/summary",
                            "page": "controlspage",
                            "width": 2,
                        },
                    ]
                },
                {
                    "id": "controlspage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewControl",
                            "width": 2,
                            "icon": "fa-map-pin",
                            "color": "green",
                            "form": {
                                "form": "ControlForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-map-pin",
                            "color": "belize hole",
                            "search": false,
                            "url": "/event/:eventKey/control",
                            "form": {
                                "form": "ControlForm"
                            }
                        }
                    ]
                },
            ]
        }
    };


    get guiModel() {
        return this._guiModel;
    }
}