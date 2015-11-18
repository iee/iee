package org.eclipse.iee.core.document.text;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.IHasPropertyChangeListener;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;

public class TextStyle implements IHasPropertyChangeListener {

	private final transient PropertyChangeSupport fpcs = new PropertyChangeSupport(this);

	private Map<String, IStyleValue> fValues = new HashMap<>();
	
	private Optional<TextStyle> fParent = Optional.absent();
	
	private PropertyChangeListener fListener;
	
	public TextStyle() {
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				String name = evt.getPropertyName();
				getPropertyChangeSupport().firePropertyChange(name, getValue(name, Object.class, new Supplier<Optional<Object>>() {
					@Override
					public Optional<Object> get() {
						return Optional.fromNullable(evt.getOldValue());
					}
				}), getValue(name, Object.class, new Supplier<Optional<Object>>() {
					@Override
					public Optional<Object> get() {
						return Optional.fromNullable(evt.getNewValue());
					}
				}));
			}
		};
	}
	
	public void setParent(Optional<TextStyle> parent) {
		if (fParent.isPresent()) {
			fParent.get().removePropertyChangeListener(fListener);
		}
		fParent = parent;
		if (parent.isPresent()) {
			parent.get().addPropertyChangeListener(fListener);
		}
	}
	
	public Optional<Boolean> isItalic() {
		return getValue("italic", Boolean.class);
	}

	public void setItalic(boolean italic) {
		setValue("italic", italic);
	}

	public Optional<Boolean> isBold() {
		return getValue("bold", Boolean.class);
	}

	public void setBold(boolean bold) {
		setValue("bold", bold);
	}

	public Optional<String> getFont() {
		return getValue("font", String.class);
	}

	public void setFont(String font) {
		setValue("font", font);
	}

	public Optional<Integer> getFontSize() {
		return getValue("fontSize", Integer.class);
	}

	public void setFontSize(int fontSize) {
		setValue("fontSize", fontSize);
	}

	public Optional<Color> getFgColor() {
		return getValue("fgColor", Color.class);
	}

	public void setFgColor(Color fgColor) {
		setValue("fgColor", fgColor);
	}

	public Optional<Color> getBgColor() {
		return getValue("bgColor", Color.class);
	}

	public void setBgColor(Color bgColor) {
		setValue("bgColor", bgColor);
	}
	
	public <T> Optional<T> getValue(final String name, final Class<T> value) {
		Supplier<Optional<T>> parentV = new Supplier<Optional<T>>() {
			@Override
			public Optional<T> get() {
				if (fParent.isPresent()) {
					return fParent.get().getValue(name, value);
				}
				return Optional.absent();
			}
		};
		return getValue(name, value, parentV);
	}

	private <T> Optional<T> getValue(final String name, Class<T> value, Supplier<Optional<T>> parentV) {
		if (!fValues.containsKey(name)) {
			return parentV.get();
		}
		return Optional.of((T) fValues.get(name).get());
	}
	
	public void setValue(String name, final Object value) {
		Optional<?> oldV = getValue(name, Object.class);
		IStyleValue newV = new IStyleValue() {
			@Override
			public Object get() {
				return value;
			}
		};
		fValues.put(name, newV);
		fpcs.firePropertyChange(name, oldV.isPresent() ? oldV : null, value);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		fpcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		fpcs.removePropertyChangeListener(listener);
	}

	protected PropertyChangeSupport getPropertyChangeSupport() {
		return fpcs;
	}
	
	
}
