words = [
    {
        singular: 'advocaat-generaal',
        multiple: 'advocaten-generaal'
    },
    {
        singular: 'advocaat',
        multiple: 'advocaten'
    },
    {
        singular: 'adv.',
        multiple: 'advctn.'
    },
    {
        singular: 'raadsman',
        multiple: 'raadsmannen'
    },
    {
        singular: 'raadman',
        multiple: 'raadmannen'
    },
    {
        singular: 'raadsheer',
        multiple: 'raadsheren'
    },
    {
        singular: 'raadsvrouw',
        multiple: 'raadsvrouwen'
    },
    {
        singular: 'raadvrouw',
        multiple: 'raadvrouwen'
    },
    {
        singular: 'griffier',
        multiple: 'griffiers'
    },
  {
    singular: 'waarnemend-griffier',
    multiple: 'waarnemend-griffiers'
  },
    {
        singular: 'procureur',
        multiple: 'procureurs'
    },
    {
        singular: 'officier van justitie',
        multiple: 'officieren van justitie'
    },
    {
        singular: 'rechter',
        multiple: 'rechters'
    },
    {
        singular: 'rechter-commissaris',
        multiple: 'rechter-commissarissen'
    },
]

File.write('roles_single.lst',words.map {|word| word[:singular]}.sort.join("\n"))
File.write('roles_multiple.lst',words.map {|word| word[:multiple]}.sort.join("\n"))
