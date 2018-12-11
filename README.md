# kc4s
Django templates for KC4S platform 

## installation
This is a Django template to be used in conjunction with Miller AND resume-client as basic template. 
It basically sucstitute the index.html file which contains a few configuration options. 
Consider to fork and modify resume-client should you need to modify other things.
Clone this repo, for isntance to `/path/to/kc4s`.

In your `miller/local_settings.py` file add the absolute url of your kc4s local installation:

```python
MILLER_TEMPLATE_BASE_DIR = '/Users/danieleguido/tools/resume-client'

# ...

TEMPLATES = [
  {
      'BACKEND': 'django.template.backends.django.DjangoTemplates',
      'DIRS': [
        '/path/to/kc4s',
        MILLER_TEMPLATE_BASE_DIR, os.path.join(_BASE_DIR, 'miller', 'templates')],
      'APP_DIRS': True,
       ]`
```
That's it!
