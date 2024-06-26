# Avatar

Avatar represents people using icons, labels and images.

## Info

| Name | Value |
| --- | --- |
| Tag | avatar
| Component Class | org.primefaces.component.avatar.Avatar
| Component Type | org.primefaces.component.Avatar
| Component Family | org.primefaces.component |
| Renderer Type | org.primefaces.component.AvatarRenderer
| Renderer Class | org.primefaces.component.avatar.AvatarRenderer

## Attributes

| Name | Default | Type | Description |
| --- | --- | --- | --- |
| id | null | String | Unique identifier of the component
| rendered | true | Boolean | Boolean value to specify the rendering of the component, when set to false component will not be rendered.
| binding | null | Object | An el expression that maps to a server side UIComponent instance in a backing bean
| label | null | String | Defines the text to display.
| icon | null | String | Defines the icon to display.
| size | null | String | Size of the element, valid options are "large" and "xlarge".
| shape | square | String | Shape of the element, valid options are "square" and "circle".
| style | null | String | Style of the avatar.
| styleClass | null | String | StyleClass of the avatar.
| dynamicColor | false | Boolean | Dynamically assign contrasting foreground and background colors based on the label.
| saturation | 100 | Integer | Saturation of dynamicColor (0 .. 100).
| lightness | 40 | Integer | Lightness of dynamicColor (0 .. 100).
| alpha | 100 | Integer | Alpha of dynamicColor (0 .. 100).
| gravatar | null | String | Gravatar e-mail address for the profile to be displayed.
| gravatarConfig | null | String | Optional Gravatar configuration for any other Gravatar API URL parameters.

## Getting Started
Avatar has three built-in display modes; "label", "icon" and custom content.

```xhtml
<p:avatar label="P"/>
<p:avatar icon="pi pi-search"/>
```

## Images
```xhtml
<p:avatar>
   <p:graphicImage name="user.png" />
</p:avatar>
```

## Sizes
`size` property defines the size of the Avatar with "large" and "xlarge" as possible values.

```xhtml
<p:avatar label="P" size="large"/>
```

## AvatarGroup
A set of Avatars can be displayed together using the `p:avatarGroup` component.

```xhtml
<p:avatarGroup>
    <p:avatar label="P"/>
    <p:avatar icon="pi pi-search"/>
    <p:avatar>
        <p:graphicImage name="user.png" />
    </p:avatar>
    <p:avatar label="+2"/>
</p:avatarGroup>
```

## Shape
Avatar comes in two different styles specified with the `shape` property, "square" is the default and "circle" is the alternative.

```xhtml
<p:avatar label="P" shape="circle"/>
```

## Badge
A badge can be added to an Avatar.

```xhtml
<p:badge value="4">
    <p:avatar icon="pi pi-user" size="xlarge"/>
</p:badge>
```

## Templating
Content can easily be customized with the default slot instead of using the built-in modes.

```xhtml
<p:avatar>
    Content
</p:avatar>
```

## Gravatar
A Gravatar is a Globally Recognized Avatar. You upload an image and create your public profile just once,
and then when you participate in any Gravatar-enabled site, your Gravatar image and public profile will automatically
follow you there. For configuration options please see API docs: https://en.gravatar.com/site/implement/images/

```xhtml
<p:avatar gravatar="contact@primetek.com.tr" gravatarConfig="d=mp" />
```

### Fallback

If you provide a label or icon, and don't set `gravatarConfig` (or use `d=blank`), the label or icon will be shown if no Gravatar is found.

```xhtml
<p:avatar gravatar="fallback@primetek.com.tr" label="Fallback" />
```

## Skinning of Avatar
Avatar resides in a main container element which `style` and `styleClass` options apply. As skinning
style classes are global, see the main theming section for more information. Following is the list of
structural style classes;

| Name | Element |
| --- | --- |
|.ui-avatar | Container element.
|.ui-avatar-circle | Container element with a circle shape.
|.ui-avatar-text | Text of the Avatar.
|.ui-avatar-icon | Icon of the Avatar.
|.ui-avatar-lg | Container element with a large size.
|.ui-avatar-xl | Container element with an xlarge size.
|.ui-avatar-dynamic | Container element with dynamic color.
|.ui-avatar-dark | Container element with dark dynamic color.
|.ui-avatar-light | Container element with light dynamic color.

## Skinning of AvatarGroup

| Name | Element |
| --- | --- |
|.ui-avatar-group | Container element.