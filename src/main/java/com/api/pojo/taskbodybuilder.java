package com.api.pojo;

public class taskbodybuilder
{
    private Projectjira project;

    private String summary;
    private String description;

    private Jiraissuetype issuetype;
    private  Taskbody fields;
    public taskbodybuilder setKey(Projectjira project) {
        this.project = project;
        return this;

    }
    public taskbodybuilder setIssnename(Jiraissuetype issuetype)
        {
        this.issuetype = issuetype;
        return this ;
    }

    public taskbodybuilder setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public taskbodybuilder setDescription(String description) {
        this.description = description;
        return this;
    }


    private taskbodybuilder () {}
    public static taskbodybuilder builder()
    {
        return new taskbodybuilder();

    }

    public Taskbody build ()
    {
        return new Taskbody(this.project,this.summary , this.description , this.issuetype);
    }

    public Jirafields buildfields()
    {
        return new Jirafields(this.fields);
    }
}
